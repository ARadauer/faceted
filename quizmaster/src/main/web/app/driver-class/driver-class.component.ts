import {Component, OnInit} from "@angular/core";
import {DriverClassService} from "./driver-class.service";
import {DriverClassTO, DriverClassType} from "../../typings/fcc";
import {LocalDataSource} from "ng2-smart-table";

@Component({
  selector: 'app-driver-class',
  templateUrl: './driver-class.component.html',
  styleUrls: ['./driver-class.component.scss']
})
export class DriverClassComponent implements OnInit {

  onLoadErrorMsg: string;

  numericDriverClasses: LocalDataSource;
  alphabeticDriverClasses: LocalDataSource;
  freetextDriverClasses: LocalDataSource;


  constructor(private driverClassService: DriverClassService) {
    this.numericDriverClasses = new LocalDataSource([]);
    this.alphabeticDriverClasses = new LocalDataSource([]);
    this.freetextDriverClasses = new LocalDataSource([]);

  }

  ngOnInit() {
    console.log('ng init von driver class');
  }


  loadDriverClassesByType(type: DriverClassType, sink: LocalDataSource) {
    this.driverClassService.getAllForType(type).subscribe(
        driverClasses => sink.load(driverClasses),
        error => this.onLoadErrorMsg = <any>error);
  }

  onCreateDriverClass(event, type: DriverClassType): void {
    let driverClass = null;

    if (!driverClass) {
      event.confirm.reject();
      return;
    }

    this.driverClassService.add(driverClass).subscribe(driverClass => {
      if (driverClass != null) {
        event.confirm.resolve(driverClass);
      }
      else {
        // service couldn't save the object -> maybe inform user about it
        event.confirm.reject();
      }
    }, error => {
      // TODO how to inform User about error?
      alert(error);
      event.confirm.reject();
    });
  }

}