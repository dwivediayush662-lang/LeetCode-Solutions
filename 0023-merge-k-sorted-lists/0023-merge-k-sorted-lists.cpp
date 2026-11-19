/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    // Custom comparator to make the priority_queue act as a Min-Heap
    struct compare {
        bool operator()(ListNode* a, ListNode* b) {
            return a->val > b->val; // Smallest value stays on top
        }
    };

    ListNode* mergeKLists(std::vector<ListNode*>& lists) {
        // Create a min-heap of ListNode pointers
        std::priority_queue<ListNode*, std::vector<ListNode*>, compare> minHeap;

        // Step 1: Push the head of each non-empty list into the heap
        for (ListNode* list : lists) {
            if (list != nullptr) {
                minHeap.push(list);
            }
        }

        // Dummy node helps easily construct the head of the new list
        ListNode dummy(0);
        ListNode* tail = &dummy;

        // Step 2: Pop the smallest element, link it, and push its next element
        while (!minHeap.empty()) {
            ListNode* smallest = minHeap.top();
            minHeap.pop();

            tail->next = smallest; // Append the smallest node to our result list
            tail = tail->next;     // Move the tail pointer forward

            // If this node has a next element, push it into the heap
            if (smallest->next != nullptr) {
                minHeap.push(smallest->next);
            }
        }

        return dummy.next; // Return the actual head of the merged list
    }
};