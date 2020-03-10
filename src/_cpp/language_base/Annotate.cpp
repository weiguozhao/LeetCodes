//
// Created by Weiguo on 2020/3/10.
//

#include "Annotate.h"

std::string Annotate::describe() {
  /**
   * 多行注释不能嵌套
   * */

  /**
   * 下面的方式常用于对程序进行debug，
   * 上线的时候只需要把 1 设置成 0
   * Note：这里只能用具体的值表示，不能通过变量来判断；即 1 的位置必须是个常量
   * */
#if 0
  return "flag is true";
#else
  return "flag is false";
#endif
}

void Annotate::testMethod() {
  auto ans = this->describe();
  std::cout << ans << std::endl;
}
