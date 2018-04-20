CREATE TABLE Admin_Information(

  Admin_User_name varchar(20) not null primary key,
  AdminFirst_name  varchar(20) not null,
  AdminLast_name  varchar(20) not null,
  Admin_Pass_word varchar(20) not null,

  Admin_Re_Enter_Password varchar(20) not null,

  Admin_gender varchar(20) not null,

  Admin_Address  varchar(100)  not null,

  Admin_Phone  long not null,

  Admin_Email   varchar(50) not null,
  
  constraint ck_Admingender check (Admin_gender in ('Male','Female')),

  constraint ck_AdminEmail check (Admin_Email like '%_@_%'),

  constraint ck_AdminReEnterPassword check (Admin_Re_Enter_Password=Admin_Pass_word)
  

);

CREATE TABLE User_Information(
    
  User_Name varchar(20) not null primary key,

  FirstName varchar(20) not null,

  LastName varchar(20) not null,

  Pass_Word varchar(20) not null,

  Re_Enter_Password varchar(20) not null,

  Gender varchar(20) not null,

  Address  varchar(100)  not null,

   Phone   int not null,

   Email   varchar(50) not null,
   
    constraint ck_gender check (gender in ('Male','Female')),

   constraint ck_email check (Email like '%_@_%'),

   constraint ck_Re_Enter_Password check (Re_Enter_Password=Pass_word) 
);


Create table Item_Information(
 
  Admin_User_name varchar(20) not null?
  Item_name varchar(20) not null primary key,

  Item_Price Decimal(20,2) not null,
  
  Item_Image varchar(200) not null,

  Item_Description  varchar(500) not null,

  Item_Active int not null,

  Item_Category varchar(20) not null ,
  
  Item_Quantity int not null,
  
  Shop varchar(20) not null,

  constraint ck_Item_Active CHECK (Item_Active= 0 or Item_Active = 1),
  
  constraint fk_Admin_Username FOREIGN KEY(Admin_User_name)

  REFERENCES Admin_information(Admin_User_name)

);

CREATE TABLE Location_Information(
   LocationList varchar(20) not null,
  Admin_User_name varchar(20) not null,

  Admin_Location_name varchar(20) not null,

  Admin_Address varchar(20) not null,
  
  Admin_City varchar(20) not null,

  Admin_Number_staff  int not null,

  Admin_Zipcode long not null,
  
  Admin_Image varchar(200) not null,


  constraint fk_Admin_User_name FOREIGN KEY(Admin_User_name)

  REFERENCES Admin_information(Admin_User_name)

);

CREATE TABLE PaymentCredit(
   user_name  varchar(20) not null,
   Credit_Card_Number int not null primary key,

   Secure_code int not null,

   ZipCode int not null,
   
   constraint ck_Secure_code check (Secure_code<=3),

   constraint ck_ZipCode check (ZipCode <=3 ),
   
   CONSTRAINT fk_puser_name FOREIGN KEY(user_name)
   REFERENCES User_Information(user_name)
 
);

Create table Order_Information(

  Admin_User_name varchar(20) not null,
  
  User_name varchar(20) not null primary key,
 
  Item_name varchar(20) not null,

  Item_Price Decimal(20,2) not null,
  
  Item_Image varchar(200) not null,
  
  Item_Quantity int not null,
  
  Location_name varchar(20) not null,
  
  Address varchar(20) not null, 
  
  City Varchar(20) not null, 
  Zipcode long not null,
    
  constraint fk_Username FOREIGN KEY(User_name)

  REFERENCES user_information(User_name),
  
  constraint fk_AdminUsername FOREIGN KEY(Admin_User_name)

  REFERENCES Admin_information(Admin_User_name)

);
drop table Location_Information;
drop table Item_Information;
commit;
drop table Login_Information;