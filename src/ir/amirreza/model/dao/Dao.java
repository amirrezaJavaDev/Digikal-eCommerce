package ir.amirreza.model.dao;

import ir.amirreza.ProjectException.erorr.ExistsException;
import ir.amirreza.ProjectException.erorr.FileNotFoundException;
import ir.amirreza.ProjectException.erorr.NotFoundException;
import ir.amirreza.model.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Dao<T extends Entity> {
    private final String FILE_PATH = "C:/Users/IT CITY/Documents/Digikal";
    protected Dao(){}
    private Collection<T> readFromFile(){
        try {
            File dir = new File(FILE_PATH);
            if(!dir.exists()){
                dir.mkdir();
            }
            File fileLocation = new File(FILE_PATH+'/'+getFileName());
            if(!fileLocation.exists()){
                fileLocation.createNewFile();
            }
            if(fileLocation.length() == 0){
                writeToFile(new ArrayList<>());
            }
            FileInputStream fileInputStream = new FileInputStream(fileLocation);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            return (Collection<T>) objectInputStream.readObject();
        }catch (IOException|ClassNotFoundException e){
            throw  new FileNotFoundException();
        }
    }
    private void writeToFile(Collection<T> records){
        File file = new File(FILE_PATH+'\\'+getFileName());
        try {
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(records);
        }catch (IOException e){
            throw  new FileNotFoundException();
        }
    }
    protected abstract String getFileName();

    public T getById(long id){
        return getAll()
                .stream()
                .filter(item -> item.getId()==id)
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
    public Collection<T> getAll(){
        return  readFromFile();
    }
    public void save(T item){
        Collection<T> items = getAll();
        items
                .stream()
                .filter(record -> record.equals(item))
                .findAny()
                .ifPresent(user -> {
                    throw new ExistsException();
                });

        items.add(item);
        writeToFile(items);
    }
    public void update(long id, T item) {
        getById(id);
        delete(id);
        save(item);
    }

    public void delete(long id) {
        List<T> collectionWithoutItem = getAll()
                .stream()
                .filter(user -> user.getId() != id)
                .collect(Collectors.toList());

        writeToFile(collectionWithoutItem);
    }



}
