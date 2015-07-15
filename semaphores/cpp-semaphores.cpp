#include <iostream>           // std::cout
#include <thread>             // std::thread, std::this_thread::yield
#include <mutex>              // std::mutex, std::unique_lock
#include <condition_variable> // std::condition_variable

std::mutex cv_mtx;
std::condition_variable cv;

void dbl_wait() {
    std::unique_lock<std::mutex> lck(cv_mtx);
    cv.wait(lck);
}

void dbl_reactivate_all() {
    cv.notify_all();
}


// each shared variable requires a mutex for protecting access
std::mutex sem_count_mtx;
int sem_count = 1;

void take() {
    sem_count_mtx.lock();
    while (sem_count == 0) {
        sem_count_mtx.unlock();
        dbl_wait();
        sem_count_mtx.lock();
    }
    sem_count_mtx.unlock();

    // lock which is actually unnecessary but which is generated for each shared variable access
    sem_count_mtx.lock();
    sem_count = sem_count - 1;
    sem_count_mtx.unlock();
}

void give() {
    sem_count_mtx.lock();
    sem_count = sem_count + 1;
    sem_count_mtx.unlock();
    dbl_reactivate_all();
}

int count = 0;
int limit = 10;

// counter
void actions() {
    while (count < limit) {
        take();
        count++;
        std::cout << std::this_thread::get_id() << ">> new count: " << count << std::endl;
        give();
        std::this_thread::yield();
    }
}

int main() {
    std::thread c1(actions);
    std::thread c2(actions);

    c1.join();
    c2.join();

    return 0;
}
