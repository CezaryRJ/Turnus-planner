using System;
using System.Collections.Generic;
using Person1;

namespace Shift1
{

    //6,6,1

    enum Shift_types
    {
        Morning, //min 2x healts worker, 4x other 
        Evening, //min 2x healts worker, 4x other 
        Night,  //1xhealts 
        Other
    }

    class Shift
    {

        int nurse;
        int assistant;
        int healt_worker;
        int other;

        int workers_on_shift;

        public Shift(int nurse, int assistant,int healt_worker,int other)
        {
            this.nurse = nurse;
            this.assistant = assistant;
            this.healt_worker = healt_worker;
            this.other = other;

            workers_on_shift = nurse + assistant + healt_worker + other;
        }


     

        List<Person> workers = new List<Person>();

        Shift_types type;

        DateTime date
        {
            get { return date; }
            set { date = value; }
        }// = new DateTime(2008, 6, 1, 7, 47, 0);

    }
}
