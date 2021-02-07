Sources:
- https://github.com/ReactiveX/RxJava
- https://github.com/eugenp/tutorials/tree/master/rxjava-core

To mention:
From the [Reactive Manifesto](https://www.reactivemanifesto.org/), reactive systems are:
- Responsive: Systems should respond in a timely manner
- Message Driven: Systems should use async message-passing between components to ensure loose coupling
- Elastic: Systems should stay responsive under high load
- Resilient: Systems should stay responsive when some components fail


Observable: Get data from a data source and whose state may be of interest in a way that other objects may register an interest
- Non-Blocking: Asynchronous execution is supported and is allowed to unsubscribe at any point in the event stream.
- Blocking: All onNext observer calls will be synchronous, and it is not possible to unsubscribe in the middle of an event stream

Observer: Any object that wishes to be notified when the state of another object changes