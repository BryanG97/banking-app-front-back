import { Component } from '@angular/core';
import { ClientCreateComponent } from '../client-create/client-create.component';
import { CommonModule } from '@angular/common';
import { ClientVo } from '../../../shared/vo/client-vo';
import { ClientService } from '../../../core/client.service';
import { ResponseVo } from '../../../shared/vo/response/response-vo';

@Component({
  selector: 'app-client-list',
  standalone: true,
  imports: [
    CommonModule,
    ClientCreateComponent
  ],
  templateUrl: './client-list.component.html',
  styleUrl: './client-list.component.scss'
})
export class ClientListComponent {

  showCreateClient = false;

  clientList: ClientVo[];

  constructor(
    private clientService: ClientService,
  ){
    this.clientList = [];
  }

  ngOnInit(): void {
    this.getClientList();
  }

  /**
   * Method to get the client list
   */
  getClientList(){
    this.clientService.getAllClients().subscribe((responde: ResponseVo) =>{
      if(responde.data){
        this.clientList = responde.data;
      }
    });
  }
 
  /**
   * Method to show the create client modal
   */
  showCreateClientModal() {
    this.showCreateClient = true;
  }

  /**
   * Method to hide the create client modal
   */
  hideCreateClientModal() {
    this.showCreateClient = false;
  }

  /**
   * Method to reload the client list
   */
  reloadList(){
    this.getClientList();
  }
}
