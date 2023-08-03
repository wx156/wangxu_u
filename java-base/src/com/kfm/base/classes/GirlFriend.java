package com.kfm.base.classes;

public class GirlFriend {
    /*\
    定义一个女朋友类（GirlFriend）女朋友的属性包含：姓名，身高，体重。行为包含：洗衣服wash()，做饭cook()。
    另外定义一个用于展示三个属性值的show()方法。请在测试类中通过有参构造方法创建对象并赋值，
    然后分别调用展示方法、洗衣服方法和做饭方法。打印效果如下：

	我女朋友叫凤姐,身高155.0厘米,体重130.0斤

	女朋友帮我洗衣服

	女朋友给我做饭
     */
    public String name = "女朋友";
    public double stature;
    public double weight;
    public void show(){
        System.out.println("我的女朋友叫"+ name + "，"+"身高是" + stature + "厘米"+ "体重"+ weight + "斤");
    }
    public String wash(){
        return (name + "帮我洗衣服");
    }
    public String cook(){
        return (name + "给我做饭");
    }
}
