

drop table emp_table;

select * from emp_table;

commit; 

insert into emp_table (employee_id, first_name, salary) values (101, 'Sonu', 90000);

select * from dep_table;

insert into dep_table (department_id, department_name, city) values (11, 'HR', 'Hyderabad');
insert into dep_table (department_id, department_name, city) values (12, 'Admin', 'Bengaluru');
insert into dep_table (department_id, department_name, city) values (13, 'Accounts', 'Chennai');
insert into dep_table (department_id, department_name, city) values (14, 'Production', 'Pune');

commit; 

