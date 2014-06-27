# om-examples

Small examples based on questions I've gotten on the CLJS mailing list, IRC, etc.  Feel free to make a pull request!

Current versions:

```clojure
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2234"]
                 [om "0.6.4"]
                 [sablono "0.2.17"]]

  :plugins [[lein-cljsbuild "1.0.3"]]
```

## Examples

```bash
lein cljsbuild once resize-listener
```

Extremely simple example of how to listen for and re-render an Om component via resize events and state changes.

```bash
lein cljsbuild once same-data-different-component
```

Using two different components with the same data set, alternating based on a hash-map field value.


## License

[MIT license](http://opensource.org/licenses/MIT)


## Authors

Copyright 2014 Dave Della Costa.

Contributions welcome!  Make a pull request.
