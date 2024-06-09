use std::io::{self, BufRead};

pub fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();
    let mut t: i32 = lines.next().unwrap().unwrap().parse().unwrap();
    
    while {t-=1; t} >= 0 {
        let values = lines.next().unwrap().unwrap();
        let values: Vec<usize> = values.split_whitespace()
                                    .map(|s| {s.parse().unwrap()})
                                    .collect();
        let (a, b) = (values[0], values[1]);
        let first_list:Vec<usize> = make_list(a % 10);
        let len = first_list.len();
        let idx = (b - 1) % len;
        println!("{}", first_list.get(idx).unwrap());
    }
}

fn make_list(mut num:usize) -> Vec<usize>{
    let mut vec:Vec<usize> = Vec::new();
    let memo = num;
    if num == 0 {
        vec.push(10);
    }else {
        vec.push(num);
    }
    while {num *= memo; num %= 10; num} != memo {
        vec.push(num);
    }
    return vec;
}