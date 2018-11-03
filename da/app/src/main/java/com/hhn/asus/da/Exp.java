package com.hhn.asus.da;

/*
 * 项目名： da
 * 包名：   com.hhn.asus.da
 * 文件名： Exp
 * 创建者： NA
 * 创建时间：2018/11/1 19:51
 * 描述：   TODO
 */
public class Exp {
    private int item_num = 0;// 0:两项，1：三项
    private int sign_num = 0;// 0+,1-,2*,3/
    private int sign_num_1 = 0;// 0+,1-,2*,3/ 三项的时候需要两个运算符
    private int kuohao = 0;// 0不产生括号，1产生括号
    private int kuohao_weizhi = 0;// 0表示前2项有括号，1表示后2项有括号

    private int result;// 结果

    private StringBuilder exp=new StringBuilder();// 式子

    enum Sign {
        add, subtract, multiply, divide
    }

    Exp() {
        while(true){
            if(createExp()==true)
            {
                break;
            }
        }
    }

    public StringBuilder getExp() {
        return exp;
    }

    public void setExp(StringBuilder exp) {
        this.exp = exp;
    }

    public void setResult(int result) {
        this.result = result;
    }

    private boolean createExp() {
        item_num = (int) (Math.random() * 3);
        sign_num = (int) (Math.random() * 4);
        int a = (int) (Math.random() * 100);// 随机生成0-100以内的数
        int b = (int) (Math.random() * 100);
        int c = (int) (Math.random() * 100);
        int d = (int) (Math.random() * 100);
        kuohao = (int) (Math.random() * 2);

        android.util.Log.e("jhd", item_num+"");
        android.util.Log.e("jhd", sign_num+"");
        android.util.Log.e("jhd", kuohao+"");
        android.util.Log.e("jhd", a+"");
        android.util.Log.e("jhd", b+"");
        android.util.Log.e("jhd", c+"");
        android.util.Log.e("jhd", d+"");

        if (item_num == 0) {// 产生2项的情况
            String temp = "";
            switch (sign_num) {
                case 0:// +
                    temp = a + "+" + b;
                    result = a + b;
                    break;
                case 1:// -
                    temp = a + "-" + b;
                    result = a - b;
                    break;
                case 2:// *
                    temp = a + "*" + b;
                    result = a * b;
                    break;
                case 3:// /
                    temp = a + "÷" + b;
                    if (a % b != 0) {// 不整除旧返回false
                        return false;

                    }
                    result = a / b;
                    break;
            }
            exp.append(temp);
        }
        if (item_num == 1) {// 式子为三项时

            sign_num_1 = (int) (Math.random() * 4);// 随机产生一个运算符
            if (kuohao == 0) {// 不产生括号
                // 比较优先级
                String temp;
                if (sign_num <= 1 && sign_num_1 > 1) {// 先计算后两项

                    if (calculate(b, sign_num_1, c) == null) {
                        return false;
                    }
                    result = calculate(a, sign_num, calculate(b, sign_num_1, c));
                    exp.append(a + getSign(sign_num) + b + getSign(sign_num_1)
                            + c);
                } else {// 计算前两项
                    if (calculate(a, sign_num, b) == null) {
                        return false;
                    }
                    if (calculate(calculate(a, sign_num, b), sign_num_1, c) == null) {
                        return false;
                    }
                    result = calculate(calculate(a, sign_num, b), sign_num_1, c);
                    exp.append(a + getSign(sign_num) + b + getSign(sign_num_1)
                            + c);
                }
            }
            else{
                return false;
            }


        }

        return true;

    }

    public Integer calculate(int a, int sign, int b) {
        Integer temp = null;
        switch (sign) {
            case 0:
                temp = a + b;
                break;
            case 1:
                temp = a - b;
                break;
            case 2:
                temp = a * b;
                break;
            case 3:
                if (a % b != 0) {// 保证能整除
                    return null;
                }
                temp = a / b;
                break;
        }
        return temp;
    }

    private String getSign(int sign) {
        String temp = null;
        switch (sign) {
            case 0:
                temp = "+";

                break;
            case 1:
                temp = "-";

                break;
            case 2:
                temp = "*";

                break;
            case 4:
                temp = "/";

                break;
        }
        return temp;
    }

    public int getResult() {// 得到产生表达式的结果
        return result;
    }

    private class Log {
    }

    /*public String getExpression() {// 得到产生的表达式
        //if(get)
    }*/

}

