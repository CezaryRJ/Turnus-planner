using System;
using System.Collections.Generic;
using Person1;
using Week1;
using Day1;
using Shift1;

namespace Turn
{

  class Turnus
    {
        Week[] weeks;
 

        List<Person> Nurses;
        List<Person> Health_workers;
        List<Person> Assistants;
        List<Person> Others;

        double hours_per_turnus;
        public Turnus(int length)
        {
            weeks = new Week[length];

            hours_per_turnus = 35.5 * length;
        }



        public Week[] make_turnus()
        {
            foreach (Week a in weeks)
            {
                foreach (Day b in a.days)
                {
                    foreach (Shift c in b.shifts)
                    {
                        foreach (Person p in Assistants)
                        {

                        }
                    }
                }
            }


            return weeks;
        }

        public Boolean can_work(Person a)
        {
            if (a.hours_left > 0)
            {
                return true;
            }

            return false;
        }
    }

}
