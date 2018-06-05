#include <iostream>
using namespace std;

// This template takes in objects a and b, and returns the greater object 
template <class type>
type getMax (type a, type b){
	return (a>b?a:b);
}

int main()
{
	int x = 10;
	int y = 15;
    cout<<"The greater number is "<<endl;
    return 0;
}