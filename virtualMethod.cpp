#include <iostream>
using namespace std;
/* This is an example of inheritance and virtual methods.
inheritance Animal --> Mouse.
Animal has a virtual method speak which is over witten by Mouse 
*/

class Animal {
    protected:
      int energy;
    public:
      virtual void speak(){
          cout << "** makes animal noise **" <<endl;
      }
};

class Mouse: public Animal{
    public:
    Mouse(){
       energy = 16; 
       cout<< "Mouse has been created"<<endl;
    }
    
    void speak(){
        cout<< "Squeak";
    }
    
    void displayEnergy(){
        cout<<energy<<endl;
    }
};

void func(Animal * a){ a->speak();};
int main()
{
    Animal *ani = new Animal;
    Mouse *mouse = new Mouse;
    
    func(ani);
    func(mouse);
    return 0;
}