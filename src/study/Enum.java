package study;



public class Enum {
    enum menu{
        ice,water,coffee
    };
    public static void main(String[] args) {
        for(menu m :menu.values()){
            System.out.println(m);
        }
    }
}
