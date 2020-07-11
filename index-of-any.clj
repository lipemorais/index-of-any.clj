
(defn indexed 
    "Generate a pair of from one of the element provided and a integer starting from 0. e.g. (indexed \"abc\") ; => [[0 \\a] [1 \\b] [2 \\c]]"
    [coll]
    (map-indexed vector coll))

(indexed "abcde") ; => ([0 \a] [1 \b] [2 \c] [3 \d] [4 \e])

(defn index-filter 
    "Returns a seq of all the itens inside coll that satisfies pred. e.g. (index-filter #{a} \"aaabca\") ; => (0 1 2 5)"
    [pred 
    coll]
    (when pred
        (for [[index element] (indexed coll) :when (pred element)] index)))

(index-filter #{\a} "aaabca"); => (0 1 2 5)

(defn index-of-any 
    "using take 1"
    [pred coll]
    (take 1 (index-filter pred coll)))

(index-of-any #{\a} "abc") ; => (0)

(defn index-of-any'
    "using first" 
    [pred coll]
    (first (index-filter pred coll)))

(index-of-any' #{\a} "abc") ; => (0)

(defn index-of-any''
    "wrap the search element inside a predicate(a set in this case)" 
    [pred coll]
    (first (index-filter (set pred) coll)))

(index-of-any'' "a" "abc") ; => 0