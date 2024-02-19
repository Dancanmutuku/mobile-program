#Employee management system 

#import mysql connector 
import mysql.connector

#making connection 
mydb = mysql.connector.connect(
    host="locahost",
    user="dan",
    password="123password",

    )
mycursor= mydb.cursor()

mycursor.execute("SHOW DATABASE")
for db in mycursor:
    print(db)