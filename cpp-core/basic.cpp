#include <iostream>
#include <vector>

class Object {};

class VectorList {
private:
    std::vector<Object*> data;
public:
    void add(Object* object) {
        data.push_back(object);
    }
    Object* get(int i) {
        return data[i];
    }
    int size() {
        return data.size();
    }
};

int main() {
    VectorList vector;
    vector.add(new Object());
    std::cout << vector.get(0) << std::endl;
    std::cout << vector.size() << std::endl;
}
