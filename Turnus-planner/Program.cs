using System;
using System.Collections.Generic;
using Person1;
using Turn;

namespace Turnus_planner
{
    class Program
    {
        static void Main(string[] args)
        {
            List<Person> staff = new List<Person>();

            staff.Add(new Person(1,"Truls",Ppl_type.Nurse));
            staff.Add(new Person(1, "Per", Ppl_type.Assitant));
            staff.Add(new Person(1, "Ole", Ppl_type.Health_worker));

          

            Turnus t = new Turnus(12,staff);
            t.print_staff();
        }
    }
}
