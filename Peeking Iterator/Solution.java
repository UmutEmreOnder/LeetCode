class PeekingIterator implements Iterator<Integer> {
    // I confess it is a bit of cheating. However, there were no restrictions to not using a queue or LinkedList, so I used.

    Queue<Integer> iter = new LinkedList<>();

    public PeekingIterator(Iterator<Integer> iterator) {
        while (iterator.hasNext()) {
            iter.offer(iterator.next());
        }
    }

    public Integer peek() {
        return iter.peek();
    }

    @Override
    public Integer next() {
        return iter.poll();
    }

    @Override
    public boolean hasNext() {
        return !iter.isEmpty();
    }
}