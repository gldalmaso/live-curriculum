(ns live-curriculum.json)

(defn to-json [target]
  (defn surround-char [surround-begin surround-end to-surround] (apply str surround-begin to-surround surround-end))
  (defn map-to-json [target]
    (surround-char "{" "}"
                   (apply
                    str
                    (flatten
                     (interpose
                      ","
                      (map
                       (fn [key] (apply str (surround-char "\"" "\"" (name key)) ":" (to-json (key target))))
                       (keys target)))))))
  (defn vector-to-json [target]
    (surround-char "[" "]" (apply str (flatten (interpose "," (map to-json target))))))
  (cond
    (not (coll? target)) (if (string? target)
                           (surround-char "\"" "\"" target)
                           (str target))
    (map? target) (map-to-json target)
    (vector? target) (vector-to-json target)))
                             