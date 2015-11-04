using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace System
{
    public static class StringExtensions
    {
        public static string Truncate(this string str, int size)
        {
            if (str.Length < size)
            {
                return str;
            }

            return str.Substring(0, size);
        }
    }
}
