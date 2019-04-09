(function(t){function e(e){for(var a,i,o=e[0],l=e[1],c=e[2],d=0,p=[];d<o.length;d++)i=o[d],s[i]&&p.push(s[i][0]),s[i]=0;for(a in l)Object.prototype.hasOwnProperty.call(l,a)&&(t[a]=l[a]);u&&u(e);while(p.length)p.shift()();return n.push.apply(n,c||[]),r()}function r(){for(var t,e=0;e<n.length;e++){for(var r=n[e],a=!0,o=1;o<r.length;o++){var l=r[o];0!==s[l]&&(a=!1)}a&&(n.splice(e--,1),t=i(i.s=r[0]))}return t}var a={},s={app:0},n=[];function i(e){if(a[e])return a[e].exports;var r=a[e]={i:e,l:!1,exports:{}};return t[e].call(r.exports,r,r.exports,i),r.l=!0,r.exports}i.m=t,i.c=a,i.d=function(t,e,r){i.o(t,e)||Object.defineProperty(t,e,{enumerable:!0,get:r})},i.r=function(t){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(t,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(t,"__esModule",{value:!0})},i.t=function(t,e){if(1&e&&(t=i(t)),8&e)return t;if(4&e&&"object"===typeof t&&t&&t.__esModule)return t;var r=Object.create(null);if(i.r(r),Object.defineProperty(r,"default",{enumerable:!0,value:t}),2&e&&"string"!=typeof t)for(var a in t)i.d(r,a,function(e){return t[e]}.bind(null,a));return r},i.n=function(t){var e=t&&t.__esModule?function(){return t["default"]}:function(){return t};return i.d(e,"a",e),e},i.o=function(t,e){return Object.prototype.hasOwnProperty.call(t,e)},i.p="/government/";var o=window["webpackJsonp"]=window["webpackJsonp"]||[],l=o.push.bind(o);o.push=e,o=o.slice();for(var c=0;c<o.length;c++)e(o[c]);var u=l;n.push([0,"chunk-vendors"]),r()})({0:function(t,e,r){t.exports=r("56d7")},"0300":function(t,e,r){"use strict";var a=r("e9de"),s=r.n(a);s.a},"56d7":function(t,e,r){"use strict";r.r(e);r("cadf"),r("551c"),r("f751"),r("097d");var a=r("2b0e"),s=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{attrs:{id:"app"}},[a("div",{staticClass:"bg-white p-2 border-b border-grey-light mb-8"},[a("router-link",{attrs:{to:"/"}},[a("img",{staticClass:"h-12",attrs:{alt:"Gouvernement du Grand-Duché de Luxembourg",src:r("f961")}})])],1),a("div",{staticClass:"container mx-auto px-4"},[a("router-view")],1)])},n=[],i={name:"app"},o=i,l=r("2877"),c=Object(l["a"])(o,s,n,!1,null,null,null),u=c.exports,d=(r("6762"),r("8c4f")),p=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"bg-white rounded p-8"},[r("div",{staticClass:"flex flex-col items-center"},[r("h1",{staticClass:"mb-8"},[t._v("Search vehicle information")]),r("form",{staticClass:"flex",attrs:{type:"get"},on:{submit:function(e){return e.preventDefault(),t.search(e)}}},[r("div",{staticClass:"flex bg-yellow text-xl inline-flex rounded overflow-hidden mr-4"},[r("div",{staticClass:"bg-blue p-2"},[r("svg",{staticClass:"stroke-current text-yellow",attrs:{height:"24",width:"24"}},[r("circle",{attrs:{cx:"12",cy:"12",r:"8","stroke-width":"2",fill:"transparent","stroke-dasharray":"0.001 5.6","stroke-linecap":"round"}})]),r("div",{staticClass:"text-white text-sm text-center"},[t._v("L")])]),r("input",{directives:[{name:"model",rawName:"v-model",value:t.registrationID,expression:"registrationID"}],staticClass:"bg-transparent py-2 px-4 w-32 text-2xl",attrs:{type:"text",placeholder:"AB-1234"},domProps:{value:t.registrationID},on:{input:function(e){e.target.composing||(t.registrationID=e.target.value)}}})]),r("button",{staticClass:"block bg-grey-light hover:bg-grey text-grey-darker group py-4 px-8 pr-6 rounded flex items-center",attrs:{type:"submit",disabled:0==t.registrationID.length}},[r("span",{staticClass:"mr-2"},[t._v("Search")]),r("svg",{staticClass:"text-grey-dark group-hover:text-grey-dark",attrs:{xmlns:"http://www.w3.org/2000/svg",width:"24",height:"24",viewBox:"0 0 24 24",fill:"none",stroke:"currentColor","stroke-width":"2","stroke-linecap":"round","stroke-linejoin":"round"}},[r("polyline",{attrs:{points:"9 18 15 12 9 6"}})])])])])])},v=[],h={name:"index",data:function(){return{registrationID:""}},methods:{search:function(){this.$router.push({name:"cars#show",params:{license_number:this.registrationID}})}}},m=h,f=Object(l["a"])(m,p,v,!1,null,"2c9a2329",null),g=f.exports,b=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[t.status.loading?r("div",{staticClass:"flex justify-center items-center my-32"},[r("MoonLoader",{attrs:{color:"black"}})],1):t._e(),t.status.loaded?r("div",[r("car-header"),t._m(0)],1):t._e(),t.status.failed?r("div",[t._v("Whoops... Something went wrong")]):t._e()])},C=[function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"bg-white rounded p-8"},[r("h2",{staticClass:"mb-4"},[t._v("Vehicle information")]),r("table",{staticClass:"w-full"},[r("tr",{staticClass:"border-b border-grey-lighter"},[r("td",{staticClass:"py-4"},[t._v("Vehicle category")]),r("td",{staticClass:"py-4 w-2/3"},[t._v("Car")])]),r("tr",{staticClass:"border-b border-grey-lighter"},[r("td",{staticClass:"py-4"},[t._v("Suspension type")]),r("td",{staticClass:"py-4 w-2/3"},[t._v("Hatchback")])]),r("tr",{staticClass:"border-b border-grey-lighter"},[r("td",{staticClass:"py-4"},[t._v("Brand")]),r("td",{staticClass:"py-4 w-2/3"},[t._v("PEUGEOT")])]),r("tr",{staticClass:"border-b border-grey-lighter"},[r("td",{staticClass:"py-4"},[t._v("Type")]),r("td",{staticClass:"py-4 w-2/3"},[t._v("C")])]),r("tr",[r("td",{staticClass:"py-4"},[t._v("Color")]),r("td",{staticClass:"py-4 w-2/3"},[t._v("Grey")])])])])}],_=r("cebc"),w=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("div",{staticClass:"mb-2"},[r("router-link",{staticClass:"no-underline text-grey-dark inline-flex items-center hover:text-grey-darker",attrs:{to:"/"}},[r("svg",{staticClass:"feather feather-chevron-left",attrs:{xmlns:"http://www.w3.org/2000/svg",width:"24",height:"24",viewBox:"0 0 24 24",fill:"none",stroke:"currentColor","stroke-width":"2","stroke-linecap":"round","stroke-linejoin":"round"}},[r("polyline",{attrs:{points:"15 18 9 12 15 6"}})]),t._v("\n      Back\n    ")])],1),r("div",{staticClass:"bg-white rounded mb-8"},[r("div",{staticClass:"p-8"},[r("h1",{staticClass:"mb-2"},[t._v(t._s(t.vehicle.brand))]),r("h2",[t._v(t._s(t.vehicle.government.model)+" – "+t._s(t.vehicle.registrationID))])]),r("div",{staticClass:"flex px-4"},[r("router-link",{staticClass:"no-underline px-6 py-4 block text-grey-dark hover:text-blue",attrs:{to:{name:"cars#show",params:{license_number:t.vehicle.registrationID}}}},[t._v("Basic")]),r("router-link",{staticClass:"no-underline px-6 py-4 block text-grey-dark hover:text-blue",attrs:{to:{name:"cars#trackers",params:{license_number:t.vehicle.registrationID}}}},[t._v("Trackers")]),r("router-link",{staticClass:"no-underline px-6 py-4 block text-grey-dark hover:text-blue",attrs:{to:{name:"cars#owner",params:{license_number:t.vehicle.registrationID}}}},[t._v("Owner")]),r("router-link",{staticClass:"no-underline px-6 py-4 block text-grey-dark hover:text-blue",attrs:{to:{name:"cars#travels",params:{license_number:t.vehicle.registrationID}}}},[t._v("Travels")])],1)])])},y=[],x=r("2f62"),k={name:"car-header",computed:Object(_["a"])({},Object(x["b"])({vehicle:function(t){return t.vehicles.value}}))},E=k,I=(r("0300"),Object(l["a"])(E,w,y,!1,null,"81614226",null)),O=I.exports,S=r("2fc2"),j={name:"cars-show",components:{CarHeader:O,MoonLoader:S["a"]},computed:Object(_["a"])({},Object(x["b"])({vehicle:function(t){return t.vehicles.value},status:function(t){return t.vehicles.status}})),created:function(){this.$store.dispatch("vehicles/getVehicle","AB1234")}},L=j,T=Object(l["a"])(L,b,C,!1,null,null,null),D=T.exports,$=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",[r("car-header"),t._m(0)],1)},U=[function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"bg-white rounded p-8"},[r("h2",{staticClass:"mb-8"},[t._v("Tracker History")]),r("table",{staticClass:"w-full"},[r("thead",{staticClass:"border-b-2 border-grey"},[r("tr",{staticClass:"font-normal"},[r("td",{staticClass:"py-4"},[t._v("Tracker ID")]),r("td",{staticClass:"py-4"},[t._v("Type")]),r("td",{staticClass:"py-4"},[t._v("Installed on")]),r("td",{staticClass:"py-4"},[t._v("Status")])])]),r("tbody",[r("tr",[r("td",{staticClass:"py-4"},[t._v("a28594b0-dc70-4745-9e54-b3b3fb61c437")]),r("td",{staticClass:"py-4"},[t._v("Trax P1")]),r("td",{staticClass:"py-4"},[t._v("27-03-2014")]),r("td",{staticClass:"py-4"},[r("div",{staticClass:"uppercase bg-green-lightest inline-block p-2 text-xs text-green-dark tracking-wide font-bold rounded"},[t._v("active")])])])])])])}],P={name:"Trackers",components:{CarHeader:O}},G=P,H=Object(l["a"])(G,$,U,!1,null,"763cb971",null),V=H.exports,N=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("car-header")},R=[],B={name:"Owner",components:{CarHeader:O}},A=B,M=Object(l["a"])(A,N,R,!1,null,"1e827940",null),F=M.exports,Q=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("car-header")},J=[],W={name:"Travels",components:{CarHeader:O}},q=W,z=Object(l["a"])(q,Q,J,!1,null,"c9377fc0",null),K=z.exports,X=function(){var t=this,e=t.$createElement,r=t._self._c||e;return r("div",{staticClass:"max-w-sm mx-auto"},[r("div",{staticClass:"bg-white rounded p-6 mb-8"},[r("h1",{staticClass:"text-center mb-8"},[t._v("Login")]),r("form",{on:{submit:function(e){return e.preventDefault(),t.handleSubmit(e)}}},[r("div",{staticClass:"mb-4"},[r("label",{staticClass:"block mb-2"},[t._v("Email")]),r("input",{directives:[{name:"model",rawName:"v-model",value:t.email,expression:"email"}],staticClass:"bg-grey-lightest p-4 block rounded w-full",attrs:{type:"text",placeholder:"Email"},domProps:{value:t.email},on:{input:function(e){e.target.composing||(t.email=e.target.value)}}})]),r("div",{staticClass:"mb-8"},[r("label",{staticClass:"block mb-2"},[t._v("Password")]),r("input",{directives:[{name:"model",rawName:"v-model",value:t.password,expression:"password"}],staticClass:"bg-grey-lightest p-4 block rounded w-full",attrs:{type:"password",placeholder:"Password"},domProps:{value:t.password},on:{input:function(e){e.target.composing||(t.password=e.target.value)}}})]),r("button",{staticClass:"w-full bg-blue p-4 rounded text-white",attrs:{disabled:t.loggingIn}},[t._v("Log in")])])])])},Y=[],Z={name:"login",data:function(){return{email:"",password:"",submitted:!1}},computed:{loggingIn:function(){return this.$store.state.auth.status.loggingIn}},created:function(){this.$store.dispatch("auth/logout")},methods:{handleSubmit:function(t){this.submitted=!0;var e=this.email,r=this.password,a=this.$store.dispatch;e&&r&&a("auth/login",{email:e,password:r})}}},tt=Z,et=Object(l["a"])(tt,X,Y,!1,null,"6c672456",null),rt=et.exports;a["a"].use(d["a"]);var at=new d["a"]({routes:[{path:"/",name:"index",component:g},{path:"/login",name:"login",component:rt},{path:"/cars/:license_number",name:"cars#show",component:D},{path:"/cars/:license_number/trackers",name:"cars#trackers",component:V},{path:"/cars/:license_number/owner",name:"cars#owner",component:F},{path:"/cars/:license_number/travels",name:"cars#travels",component:K}]});at.beforeEach(function(t,e,r){var a=["/login"],s=!a.includes(t.path),n=localStorage.getItem("user");if(s&&!n)return r("/login");r()});var st={findVehicle:nt};function nt(t){return fetch("/government/api/vehicles/".concat(t)).then(function(t){return t.json()}).then(function(t){return t})}var it={value:null,status:{}},ot={getVehicle:function(t,e){var r=t.commit;r("VEHICLE_REQUEST"),st.findVehicle(e).then(function(t){r("VEHICLE_SUCCESS",t)}).catch(function(t){r("VEHICLE_FAILURE")})}},lt={VEHICLE_REQUEST:function(t){t.value=null,t.status={loading:!0}},VEHICLE_SUCCESS:function(t,e){t.status={loaded:!0},t.value=e},VEHICLE_FAILURE:function(t){t.value=null,t.status={failed:!0}}},ct={namespaced:!0,state:it,actions:ot,mutations:lt},ut=r("795b"),dt=r.n(ut),pt=r("f499"),vt=r.n(pt);var ht={login:mt,logout:ft};function mt(t,e){var r={method:"POST",headers:{"Content-Type":"application/json"},body:vt()({email:t,password:e})};return fetch("/swimple/api/authentication",r).then(gt).then(function(t){return t.token&&localStorage.setItem("user",vt()(t)),t})}function ft(){localStorage.removeItem("user")}function gt(t){var e=t.json();if(!t.ok){401===t.status&&ft();var r=e&&e.message||t.statusText;return dt.a.reject(r)}return e}var bt=JSON.parse(localStorage.getItem("user")),Ct=bt?{status:{loggedIn:!0},user:bt}:{status:{},user:null},_t={login:function(t,e){var r=t.dispatch,a=t.commit,s=e.email,n=e.password;a("LOGIN_REQUEST",{email:s}),ht.login(s,n).then(function(t){a("LOGIN_SUCCESS",t),at.push("/")}).catch(function(t){a("LOGIN_FAILURE",t),r("notices/addNotice",t,{root:!0})})},logout:function(t){var e=t.commit;ht.logout(),e("LOGOUT")}},wt={LOGIN_REQUEST:function(t,e){t.status={loggingIn:!0},t.user=e},LOGIN_SUCCESS:function(t,e){t.status={loggedIn:!0},t.user=e},LOGIN_FAILURE:function(t){t.status={},t.user=null},LOGOUT:function(t){t.status={},t.user=null}},yt={namespaced:!0,state:Ct,actions:_t,mutations:wt};a["a"].use(x["a"]);var xt=new x["a"].Store({modules:{vehicles:ct,auth:yt},strict:!0});r("def6");a["a"].config.productionTip=!1,new a["a"]({router:at,store:xt,render:function(t){return t(u)}}).$mount("#app")},def6:function(t,e,r){},e9de:function(t,e,r){},f961:function(t,e,r){t.exports=r.p+"img/gov-light-2x.a84643c6.png"}});
//# sourceMappingURL=app.41ba164f.js.map