package com.seven;

/**
 * ClassName:CustomerList
 * Package:com.seven
 * Description:
 *
 * @Author mzy
 * @Create 2024/11/8 16:03
 * @Version 1.0
 */
public class CustomerList {
    private Customer[] customers;   //记录保存客户数组
    private int total;              //记录保存客户数量
    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];    //创建指定空间大小存储客户信息的数组
    }
    public boolean addCustomer(Customer customer){  //在数组中添加指定客户信息  添加成功返回true  失败返回false
        if(total<customers.length){
            customers[total++]=customer;
            return true;
        }
        return false;

    }
    public boolean replaceCustomer(int index, Customer cust){   //替换指定客户信息
        if(index>=0&&index<total){
            customers[index] = cust;
            return true;
        }
        return false;
    }
    public boolean deleteCustomer(int index){       //删除指定客户信息
        if(index<0 || index>=total) {
            return false;
        }

        for(int i =index;i<total-1;i++){        //最后一个有效位置置空
            if(i<total-1){
                customers[i]=customers[i+1];
            }
        }
        customers[--total]=null;
        return true;
    }
    public Customer[] getAllCustomers(){ //返回中记录的所有对象信息
        //新创建一个数组
        Customer[] custs = new Customer[total];
        for(int i =0;i<total;i++){
            custs[i] = customers[i];
        }
        return custs;
    }
    public Customer getCustomer(int index){ //返回指定索引位置上的客户对象
        if(index<0||index>=total){
            return null;
        }else{
            return customers[index];
        }

    }
    public int getTotal(){
        return total;
    }
}
