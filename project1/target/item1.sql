
create table user_detail(
  user_id int primary key,
  user_password varchar,
  user_type varchar,
 );
 
create table employee_details(
  emp_id int primary key,
  emp_name varchar ,
  emp_address varchar,
  
  mgr_id int foreign key,
  user_id int  foreign key
);

create table manager_details(
  mgr_id int primary key,
  mgr_name varchar,
  mgr_address varchar,
 
  emp_id  int foreign key,
  user_id int foreign key,
 
);
create table reimbursment_details(
    rb_id int primary key;
    rb_amount int,
	rb_status varchar,
	
	emp_id  int foreign key,
    user_id int foreign key,

);