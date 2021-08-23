using System;

namespace Person1
{

    enum Ppl_type
    {
        Assitant,
        Nurse,
        Health_worker
    }

    class Person
    {
     

        public int employment_percentage;
        public String name;
        public Ppl_type type;

        public double hours_left;

        public Person(int employment_percentage,String name,Ppl_type type)
        {
            this.employment_percentage = employment_percentage;
            this.name = name;
            this.type = type;
        }
        

        
    }
}
