#include "stdHeader.h"
using namespace std;

struct Employee
{
        Employee() = default;
        Employee(const string & str) :name(str) {}
        string name;
        vector<Employee*> reporters;
};

void find_path(Employee *root, Employee *a, vector<Employee*>& v, bool& found)
{
        if (found) return;
        
        v.push_back(root);

        if (root->name == a->name)
        {
                found = true;
                return;
        }        

        vector<Employee*>& r = root->reporters;
        for (int i = 0; i < r.size(); ++i)
        {
                find_path(r[i], a, v, found);
        }
        if (found) return;
        v.pop_back();
}

Employee* common_manager(Employee * root, Employee * a, Employee *b)
{
        vector<Employee*> va;
        vector<Employee*> vb;
        bool found = false;
        find_path(root, a, va, found);
        if (!found) return nullptr;

        found = false;
        find_path(root, b, vb, found);
        if (!found) return nullptr;

        int i = 0;
        Employee* e;
        while (i < va.size() && i < vb.size())
        {
                if (va[i] == vb[i])
                {
                        e = va[i];
                }
                else-baidu 1point3acres
                {
                        break;
                }
                ++i;
        }

        if (e->name == "CEO") return nullptr;
        return e;
}

void f() {}

void test_common_manager()
{
        cout << "=====================" << endl;-baidu 1point3acres
        cout << "test common manager" << endl;
        //multi-child tree to find common ancestor

        Employee *samir = new Employee("samir");
        Employee *dom = new Employee("dom");. check 1point3acres for more.
        Employee *michael = new Employee("michael");

        Employee *peter = new Employee("peter");
        Employee *porter = new Employee("porter");
        Employee *bob = new Employee("bob");

        dom->reporters.push_back(bob);
        dom->reporters.push_back(peter);
        dom->reporters.push_back(porter);

        Employee *milton = new Employee("milton");
        Employee *nina = new Employee("nina");

        peter->reporters.push_back(milton);
        peter->reporters.push_back(nina);

        Employee *bill = new Employee("bill");
        bill->reporters.push_back(dom);
        bill->reporters.push_back(samir);
        bill->reporters.push_back(michael);

        Employee *xiaopan = new Employee("xiaopan");

        std::cout << common_manager(bill, milton, nina)->name << std::endl;
        std::cout << common_manager(bill, nina, porter)->name << std::endl;
        std::cout << common_manager(bill, nina, samir)->name << std::endl;
        std::cout << common_manager(bill, peter, nina)->name << std::endl;
}