package ir.amirreza.ProjectException;

public enum DigikalExcepType {
    FILE_NOT_FOUND(-101,"در فایل ذخیره و بازیابی مشکلی پیش آمده"),
    WRONG_ENTRY(-102,"لطفا مقدار صحیح وارد نمایید"),
    AUTHENTICATION_FAILED(-104, "نام کاربری و یا رمز عبور اشتباه است."),
    DUPLICATION_USER(-105,"موجودیت تکراری"),
    NOT_FOUND(-106,"یافت نشد")
    ;
    private final int code;
    private final String messageFa;

    DigikalExcepType(int code, String messageFa) {
        this.code = code;
        this.messageFa = messageFa;
    }
     public String getMessageFa(){ return this.messageFa;}
}
