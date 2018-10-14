#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int c=0;int p=0;
char Operator(){
int k;
k=rand()%4+1;
switch(k){
case 1:return '+';
	case 2:return '-';
		case 3:return '/';
			case 4:return '*';
}}
yunsuan1(int x,int y,char s){
float answer=0;
	switch(s){
	case '+': {answer=(float)x+(float)y;break;}
	case '-': {	answer=(float)x-(float)y;break;}
	case '*':{	answer=(float)x*(float)y;break;}
	case '/':{	answer=(float)x/(float)y;break;}		
	}
	return answer;
	
}
yunsuan2(float answer,float result,char s1,int z){
	float answer1;
	switch(s1){
	case '+': {answer1=answer+(float)z;
			if(answer1==result)
			{c++;printf("恭喜你答对了！\n");}

		else {p++;printf("你答错了哦,正确答案是%.1f！\n",answer1);}break;}
	case '-': {	answer1=answer-(float)z;
			if(answer1==result)
		{c++;printf("恭喜你答对了！\n");}

		else {p++;printf("你答错了哦,正确答案是%.1f！\n",answer1);
			  }break;}
	case '*':
	
		{answer1=answer*(float)z;
			if(answer1==result)
		{c++;printf("恭喜你答对了！\n");}

		else {p++;printf("你答错了哦,正确答案是%.1f！\n",answer1);}break;}
	case '/':	answer1=answer/(float)z;
			if(answer1==result)
		{c++;printf("恭喜你答对了！\n");}

		else {p++;printf("你答错了哦,正确答案是%.1f！\n",answer1);}break;}
	


}

 void main(){
   int i, x,y,n,z;   
   printf("-------四则运算--------\n\n");
   printf("请输入题目数目:");
   scanf("%d",&i);
   for(n=0;n<i;n++){
   float  result,answer; 
   char s, s1; 
    x=rand()%100+1;  //产生随机数
    y=rand()%100+1;
	z=rand()%100+1;
    s=Operator();    //利用函数产生随机运算符
    s1=Operator();
	if(s=='-'||s=='/'){
		while(x<y){   
    x=rand()%100+1;      //若前后出现后者大于前者则重新产生随机数避免出现负数
    y=rand()%100+1;
		}

	}


printf("\n %d :%d%c%d%c%d=",n+1,x,s,y,s1,z);
scanf("%f",&result);
answer=yunsuan1(x,y,s);
 if(s1=='-'||s1=='/'){
	while(answer<z||answer<z){
	z=rand()%100+1;
	}
}
yunsuan2(answer,result,s1,z);

   }

 printf("\n本次答题情况如下：答对%d道，答错%d道\n",c,p);}