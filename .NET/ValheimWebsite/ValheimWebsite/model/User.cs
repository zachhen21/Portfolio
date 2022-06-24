using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace ValheimWebsite.model
{
    public class User
    {
        public String Name { get; set; }
        public String Email { get; set; }
        public String Date { get; set; }
        public String Confirmation { get; set; }
        public String Subject { get; set; }
        public String Message { get; set; }
    }
}