(ns live-curriculum.json)

(defn surround-char [surround-begin surround-end to-surround] (apply str surround-begin to-surround surround-end))

(defn to-json [target]
  (cond
    (not (coll? target)) (if (string? target)
                           (surround-char "\"" "\"" target)
                           (str target))
    (map? target) (surround-char "{" "}"
                                 (apply str
                                        (flatten
                                         (interpose ","
                                                    (map (fn [key] (apply str (name key) ":" (to-json (key target)))) (keys target))))))
    (vector? target) (surround-char "[" "]" (apply str (flatten (interpose "," (map to-json target)))))))
                             