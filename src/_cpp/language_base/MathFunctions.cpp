//
// Created by Weiguo on 2020/3/7.
//

double power(double base, int exp) {
  if (exp == 0) {
    return 1.0;
  }
  if (base == 0.0) {
    return 0.0;
  }

  double ans = base;
  for (int i = 1; i < exp; i++) {
    ans *= base;
  }
  return ans;
}
