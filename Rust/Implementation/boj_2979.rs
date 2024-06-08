use std::io::{self, BufRead};

pub fn main() {
    let stdin = io::stdin();
    let mut lines = stdin.lock().lines();

    let costs = lines.next().unwrap().unwrap();
    let costs: Vec<i32> = costs
        .split_whitespace()
        .map(|s| s.parse().unwrap())
        .collect();
    let (a, b, c) = (costs[0], costs[1], costs[2]);

    let mut truck_count = [0; 101];

    for _ in 0..3 {
        let times = lines.next().unwrap().unwrap();
        let times: Vec<usize> = times
            .split_whitespace()
            .map(|s| s.parse().unwrap())
            .collect();
        let (start, end) = (times[0], times[1]);

        for time in start..end {
            truck_count[time] += 1;
        }
    }

    let mut total_cost = 0;
    for time in 1..=100 {
        total_cost += match truck_count[time] {
            1 => a,
            2 => b * 2,
            3 => c * 3,
            _ => 0,
        };
    }

    println!("{}", total_cost);
}
