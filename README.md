# SRS
School Record System Demo
In the java program, i only use java.util.
in this program, it can not identify the same of capaital letter and small letter. For example, if the username is s1234567, and you input S1234567, then the program can not indentify it and display username not found or the subject name is Math and you input math, then the program will display error.

There are 2 student in this system
First student is Tom and his username and password are s1234567 and 12345678
Second student is Jerry and her username and password are s7654321 and 87654321

There is 1 teacher in this system and his username and password are t1234567 and 12345678

There are 2 subject at the begining which are English and Math.

So, you need to input the username and password correctly to enter the system record system.
Also, if you input wrong username or password, you need to re-run the program again.

For student system, there are 3 operation which are view, update, exit.

operation 1 is view, which allow student to view their personal information include name, age, address, gender and their own subject results and GPA.

opertaion 2 is update, which allow student to update their name and address, and you can input any string whatever you like.

operation 3 is exit, which allow student to leave the system.

The system will loop the student system until you enter 3 to operate exit.

For teacher system, there are 4 operation which are view, update, create and delete, exit.

operation 1 is view, which allow teacher to view any student personal inforamtion and subject record by entering the username of student. For example, input s1234567 to view Tom personal information and subject record.

operation 2 is update, you need to input the username first, and then enter the subject that you want to change the result of it. The subject should be exist. At the begining, there are only 2 subjects in the system which are English and Math. After that, you can enter the latest result.

operation 3 is create and delete, For create, you need to input the username first and enter the subject name that you want to create and then enter the result of that subject. For delete, you need to input the username and then enter the subject name that you want delete.

operation 4 is exit, which allow teacher to leave the system.

the teacher system will loop until you enter operation 4.
