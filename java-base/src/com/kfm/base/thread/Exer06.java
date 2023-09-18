public class Exer06 {

    public static void main(String[] args) {
       Test text = new Test();

       text.start();
        try {
            text.join(5000);
            System.out.println(text.getI());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
class Test extends Thread{
    int i = 4;
    @Override
    public void run() {

        while (i != Integer.MAX_VALUE){
            i++;
        }
    }

    public int getI (){
        return i;
    }

}
