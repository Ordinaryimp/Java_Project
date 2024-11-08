package com.seven;

/**
 * ClassName:CustomerView
 * Package:com.seven
 * Description:
 *
 * @Author mzy
 * @Create 2024/11/8 17:20
 * @Version 1.0
 */
public class CustomerView {
    CustomerList customerList = new CustomerList(10);
    public void enterMainMenu(){
        boolean isFlag = true;
        while(isFlag){
            //显示界面
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char key = CMUtility.readMenuSelection();
            System.out.println();
            switch (key) {
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)：");
                    char yn = CMUtility.readConfirmSelection();
                    if (yn == 'Y')
                        isFlag = false;
                    break;
            }
        }
    }
    private void addNewCustomer(){
        System.out.println("--------添加客户--------");
        System.out.println("姓名: ");
        String name = CMUtility.readString(4);
        System.out.println("性别: ");
        char gender = CMUtility.readChar();
        System.out.println("年龄: ");
        int age = CMUtility.readInt();
        System.out.println("电话: ");
        String phone = CMUtility.readString(13);
        System.out.println("邮箱: ");
        String email = CMUtility.readString(30);
        Customer cust = new Customer(name,gender,age,phone,email);
        boolean isSuccess = customerList.addCustomer(cust);
        if(isSuccess){
            System.out.println("--------添加成功--------");
        }else{
            System.out.println("------成员已满,无法添加------");
        }
    }
    private void modifyCustomer(){
        System.out.println("--------修改客户--------");
        int number = 0;
        Customer cust = null;
        for(;;){
            System.out.println("请选择待修改客户编号(-1退出)：");
            number = CMUtility.readInt();
            if(number==-1){
                return;
            }
            cust = customerList.getCustomer(number-1);
            if(cust==null){
                System.out.println("无法找到指定客户");
            }else{
                System.out.println("姓名("+cust.getName()+"): ");
                String name = CMUtility.readString(4,cust.getName());
                System.out.println("性别("+cust.getGender()+"): ");
                char gender = CMUtility.readChar(cust.getGender());
                System.out.println("年龄("+cust.getAge()+"): ");
                int age = CMUtility.readInt(cust.getAge());
                System.out.println("电话("+cust.getPhone()+"): ");
                String phone = CMUtility.readString(13,cust.getPhone());
                System.out.println("邮箱("+cust.getEmail()+"): ");
                String email = CMUtility.readString(30,cust.getEmail());
                break;
            }
        }

    }
    private void deleteCustomer(){
        System.out.println("--------删除客户--------");
        System.out.println("请选择待删除客户编号(-1退出)：");
        int number = CMUtility.readInt();
        if(number==-1){
            return;
        }
        Customer cust = customerList.getCustomer(number-1);
        if(cust==null){
            System.out.println("无法找到指定客户");
        }else{
            System.out.println("确认是否删除(Y/N)：");
            char yn = CMUtility.readConfirmSelection();
        }

    }
    private void listAllCustomers(){
        System.out.println("--------客户列表--------");
        int total = customerList.getTotal();
        if(total==0){
            System.out.println("没有客户记录");
        }else{
            Customer[] custs = customerList.getAllCustomers();
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
            for(int i=0;i<total;i++){
                Customer cust = custs[i];
                System.out.println((i+1)+"\t"+cust.getName()+"\t"+cust.getGender()+
                        "\t"+cust.getAge()+"\t"+cust.getPhone()+"\t"+cust.getEmail());
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }
}
