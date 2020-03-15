//
// Author: zhaowg
// Date  : 2020/3/14
//
//

#include "Problem1108.h"

string Problem1108::defangIPaddr(string address) {
  for (int i = (int) address.size() - 1; i >= 0; i--) {
    if (address[i] == '.') {
      address.replace(i, 1, "[.]");
    }
  }
  return address;
}
