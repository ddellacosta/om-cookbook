# om-cookbook

Small, single-concept [Om](https://github.com/swannodette/om) example recipes based on questions I've gotten on the CLJS mailing list, IRC, etc.  Feel free to make a pull request!

Also, don't forget to check out the [examples](https://github.com/swannodette/om/tree/master/examples) in Om too.

Current versions:

```clojure
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2234"]
                 [org.clojure/core.async "0.1.303.0-886421-alpha"]
                 [om "0.6.4"]
                 [sablono "0.2.17"]]

  :plugins [[lein-cljsbuild "1.0.3"]]
```

React 0.9.0 is used in all examples for the time being.

## Recipes

```bash
$ lein cljsbuild once resize-listener
```

Extremely simple example of how to listen for and re-render an Om component via resize events and state changes.

```bash
$ lein cljsbuild once same-data-different-component
```

Using two different components with the same data set, alternating based on a hash-map field value.


```bash
$ lein cljsbuild once back-it-up
```

Shows how to update both app-data (cursor) and local component state of a parent component from a child component using core.async.


## License

[MIT license](http://opensource.org/licenses/MIT)


## Authors

Copyright 2014 Dave Della Costa.

Contributions welcome!  Make a pull request.
