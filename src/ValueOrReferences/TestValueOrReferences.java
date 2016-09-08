package ValueOrReferences;

/**
 * Created by xinz.zhang on 2016/9/8.
 */
public class TestValueOrReferences {

    public static void main(String args[]){

        //值传递--针对immutable的类，如String等
        /*//String strZX = "zhangxin" ;
        String strZX = new String("zhangxin");
        System.out.println(" before changes basic: "+strZX);
        returnValues(strZX);
        System.out.println(" after changes basic: "+strZX);
        */

        //值传递--针对基础数据类型
        /*
        int count = 0;
        System.out.println(" before changes basic: "+count);
        returnValues(count);
        System.out.println(" after changes basic: "+count);
        */

        //引用传递--针对对象
       /*
        people swpeople = new people();
        System.out.println(" before changes ref: "+swpeople.getName());
        System.out.println(" before changes ref: "+swpeople.getAge());
        returnReferences(swpeople);
        System.out.println(" after changes ref: "+swpeople.getName());
        System.out.println(" after changes ref: "+swpeople.getAge());
        */
    }

    public static String returnValues(String str){
        //对于java中immutable的类，因为每次都是重新创建一个新的对象，所以可以想象成基础
        //类型，都是新的”对象“（”副本“），“值”传递
        str = str+" changes ";
        return str;
    }

    public static int returnValues(int count){
        //对于基本数据类型传递的是值的副本，那么该值改变即改变的是副本，源值不会发生变化
        count = count + 1;
        return count;
    }

    public static people returnReferences(people swpeoplw){
        //对于对象传递的是对象的引用，那么对对象所做的任何改变则会引起对源对象的改变
        swpeoplw.setName("ZHANGXIN");
        swpeoplw.setAge(25);
        return swpeoplw;
    }


}
