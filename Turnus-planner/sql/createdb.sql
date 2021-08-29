CREATE TABLE IF NOT EXISTS workers(
   id int ,
   name varchar(50) NOT NULL,
   
   employment_percentage int,
   CHECK (employment_percentage > 0 AND  employment_percentage <= 1),
   
   hours_worked int,
   CHECK ( hours_worked > 0),
   
   title ENUM('nurse', 'healt_worker', 'assistant') NOT NULL,
   
   PRIMARY KEY (id)
) ;

CREATE TABLE IF NOT EXISTS turnus(
	date DATE,
    shift ENUM('morning','evening','night'),
    
    id int,
    FOREIGN KEY (id) REFERENCES workers(id),
    
    PRIMARY KEY(date, shift)

);