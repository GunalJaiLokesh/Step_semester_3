package OOP_fundamentals.Assignment_problems;

class item{
    String itemName;
    int stock;
    int restock;
    public item(String itemName, int stock){
        this.itemName = itemName;
        this.stock = stock;
    }
    public void addRestock(int restock){
        this.stock = this.stock +restock;
    }
}
public class Q2 {
    public static void main(String[] args) {
        item [] items = new item[4];
        items[0] = new item("Samosa",4 );
        items[1] = new item("Tea powder", 2);
        items[2] = new item("Bread", 8);
        items[3] = new item("Biscuits", 2);
        for ( int i=0;i<4;i++){
            items[i].addRestock(10);
            System.out.println(items[i].itemName+" Final stock:"+items[i].stock);
        }

    }
}
