package praktikum.OOP.Abstract;

public abstract class Amphibian { // не может быть объектов
    protected String color;

    protected Amphibian(String color){
        this.color = color;
    }

    public void eat() {
        System.out.println("Кушаю");
    }

    public abstract void move();
     /*абстрактныый метод,
     нужен только тип возвращаемого значения и его сигнатура
     классы наследники по-разному реализуют данный метод
     класс-наследник должен реализовать все абстрактные методы, иначе будет ошибка при компиляции

     если в классе наследнике разработчик
     не хочет реализовывать все абстрактные методы,
     то наследник тоже должен быть объявлен как АБСТРАКТНЫЙ
     */

    public String getColor(){
        return color;
    }

}

