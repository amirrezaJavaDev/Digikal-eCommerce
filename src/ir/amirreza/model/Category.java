package ir.amirreza.model;

public class Category implements Entity {
    private long id;
    private String name;

    public Category(String categoy) {
        name = categoy;
    }
    @Override
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
