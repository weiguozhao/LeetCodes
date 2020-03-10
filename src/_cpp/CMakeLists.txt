cmake_minimum_required(VERSION 3.15)
project(_cpp)

set(CMAKE_CXX_STANDARD 14)

add_subdirectory(language_base)
add_subdirectory(leet_code)

add_executable(cpp_code main.cpp)

# 添加链接库
target_link_libraries(cpp_code LanguageBase LeetCode)
