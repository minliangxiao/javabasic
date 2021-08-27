package club.huangliang.design_model.test;

public class Duck {
    public FlyBehavior flyBehavior ;

    public static void main(String[] args) {

        /*Duck duck =new Duck();
        duck.flyBehavior = new Fly();
        duck.flyBehavior.fly();*/
        int[] nums ={4,1,2,1,2};
        int num=0;
        for(int i=0;i<nums.length;i++){
            num=num^nums[i];
        }
        System.out.println(num);
    }
}
