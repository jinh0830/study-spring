package soundsystem;

import org.springframework.beans.factory.BeanNameAware;

public class MyDisc implements CompactDisc, BeanNameAware {
    String beanId;
    @Override
    public void play() {
        System.out.println("MyDisc!!!");
    }

    @Override
    public void setBeanName(String s) {
        this.beanId = s;
        System.out.println("++++++");
        System.out.println(this.beanId);
        System.out.println("++++++");
    }
}
