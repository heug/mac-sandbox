;; Don't fuck it up - this lets svc box know that there are already VMs existing and to PLEASE not create new ones
(circle.model.settings/set! {:circle.backend.container.esxi.use-preallocated-vms true})
;; Add that VM. 
(badmin/esxi-vm-add-machine "162.253.133.112" "162.253.133.187" "osx" 2 nil)
; Declare what OSX features are available now
(circle.model.settings/set! {
                             :xcode-supported-versions "7.0,7.2,7.3,8.0,8.1,8.2"
                             :run-inference-daemon true
                             :ios-beta-enabled true
                             :enable-osx-caching false
                             :global-sudo-enabled.managed-osx false})
;; Host IP address, set it online
(circle.backend.model.esxi-vm/set-online-by-host! "162.253.133.112" true)