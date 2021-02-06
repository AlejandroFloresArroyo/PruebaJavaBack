INSERT INTO GENDER (ID, NAME) values (0, 'M');
INSERT INTO GENDER (ID, NAME) values (1, 'F');

INSERT INTO JOB (ID, NAME, SALARY) values (0, 'FrontEnd', 20);
INSERT INTO JOB (ID, NAME, SALARY) values (1, 'BackEnd', 10);
INSERT INTO JOB (ID, NAME, SALARY) values (2, 'Full Stack', 30);

INSERT INTO EMPLOYEE (ID, BIRTHDATE, NAME, LAST_NAME, GENDER_ID, JOB_ID) values (0, '2019-12-1', 'John', 'Doe', 0, 0);
INSERT INTO EMPLOYEE (ID, BIRTHDATE, NAME, LAST_NAME, GENDER_ID, JOB_ID) values (1, '2019-12-1', 'Ale', 'Flores', 1, 1);
INSERT INTO EMPLOYEE (ID, BIRTHDATE, NAME, LAST_NAME, GENDER_ID, JOB_ID) values (2, '2019-12-1', 'Karla', 'Rojas', 1, 2);
INSERT INTO EMPLOYEE (ID, BIRTHDATE, NAME, LAST_NAME, GENDER_ID, JOB_ID) values (3, '2019-12-1', 'Murphy', 'Katze', 0, 2);

INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (0, '2020-01-25', 10, 0);
INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (1, '2020-01-26', 5, 0);
INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (2, '2020-01-27', 17, 0);

INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (3, '2020-01-26', 12, 1);
INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (4, '2020-01-27', 1, 1);
INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (5, '2020-01-28', 15, 1);

INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (6, '2020-01-27', 7, 2);
INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (7, '2020-01-26', 9, 2);
INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (8, '2020-01-27', 10, 2);

INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (9, '2020-01-26', 2, 3);
INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (10, '2020-01-27', 3, 3);
INSERT INTO WORKED_HOURS (ID, WORKED_DATE, WORKED_HOURS, EMPLOYEE_ID) values (11, '2020-01-26', 5, 3);