class CountInversions {
    static merge(arr: number[], low: number, mid: number, high: number): number {
        let tempArr: number[] = [];
        let left: number = low, right: number = mid + 1, count: number = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tempArr.push(arr[left]);
                left++;
            } else {
                tempArr.push(arr[right]);
                count = count + (mid - left + 1);
                right++;
            }
        }

        while (left <= mid) {
            tempArr.push(arr[left]);
            left++;
        }

        while (right <= high) {
            tempArr.push(arr[right]);
            right++;
        }

        for (let i = low; i <= high; i++) {
            arr[i] = tempArr.shift() || 0;
        }

        return count;
    }

    static mergeSort(arr: number[], low: number, high: number): number {
        let count: number = 0;
        if (low >= high) return count;

        const mid: number = Math.floor((high - low) / 2) + low;

        count += CountInversions.mergeSort(arr, low, mid);
        count += CountInversions.mergeSort(arr, mid + 1, high);
        count += CountInversions.merge(arr, low, mid, high);

        return count;
    }

    static numberOfInversions(arr: number[]): number {
        return CountInversions.mergeSort(arr, 0, arr.length - 1);
    }

    static main(): void {
        const arr: number[] = [5, 4, 3, 2, 1];
        const count: number = CountInversions.numberOfInversions(arr);
        console.log("The number of inversions are: " + count);
    }
}

CountInversions.main();
