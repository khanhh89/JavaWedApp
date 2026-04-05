package org.example.bt5.configs;


import jdk.internal.io.JdkConsole;
import jdk.jfr.internal.jfc.model.UserInterface;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class System{
    private static UserInterface out;
    @Value("Chi nhánh Hà nội ")
    private String branchName;
    @Value("12:01")
    private String openTime;
    public void display(){
        System.out.println("Chi nhánh: "+branchName);
        System.out.println("Giờ mở cửa: "+openTime);
    }
}


