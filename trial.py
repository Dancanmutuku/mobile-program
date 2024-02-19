import os
import mysql.connector

mydb = mysql.connector.connect(
    host="localhost",
    user="root",
    password="",
    database="employees1"
)

mycursor = mydb.cursor()

# Creating table
mycursor.execute("CREATE TABLE IF NOT EXISTS empdata(Id INT PRIMARY KEY, Name VARCHAR(1000), Email_id TEXT, Phone_no INT, Address TEXT, Post TEXT, Salary BIGINT)")

def Add_New_Employee():
    print("{:<60}".format("-->> Employee added successfully<<--"))
    Id = input("Enter Employee Id: ")
    Name = input("Enter Employee Name: ")
    Email_id = input("Enter Employee Email Id: ")
    Phone_no = input("Enter Employee Phone Number Number: ")
    Address = input("Enter Employee Address: ")
    Post = input("Enter Employee Post: ")
    Salary = input("Enter Employee Salary: ")
    data = (Id, Name, Email_id, Phone_no, Address, Post, Salary)

    # Inserting employee details into the empdata table
    sql = 'INSERT INTO empdata VALUES (%s, %s, %s, %s, %s, %s, %s)'
    
    # Executing the SQL query 
    mycursor.execute(sql, data)

    # Committing to make changes in the table
    mydb.commit()
    print("Successfully added Employee Record ")
    press = input("Press Any Key To Continue...")
    menu()

# Making function to display menu 
def menu():
    os.system("cls")
    print("{:<60}".format("*******************************"))
    print("{:<60}".format("-->> Employee Management System <<--"))
    print("{:<60}".format("*******************************"))
    print("1. Add New Employee")
    print("2. Display Employee Record")
    print("3. Update Employee Record")
    print("4. Promote Employee Record")
    print("5. Remove Employee Record")
    print("6. Search Employee Record")
    print("7. Exit\n")
    print("{:>60}".format("-->> Choice Option: [1/2/3/4/5/6/7] <<--"))

    ch = int(input("Enter your Choice: "))
    if ch == 1:
        os.system("cls")
        Add_New_Employee()  # Corrected: Added parentheses for function call
    else:
        print("Invalid Choice")
        press = input("Press Any key to continue...")

# Calling the main function
menu()
