import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ClientVo } from '../../../shared/vo/client-vo';
import { PersonVo } from '../../../shared/vo/person-vo';
import { ClientService } from '../../../core/client.service';
import { ResponseVo } from '../../../shared/vo/response/response-vo';

@Component({
  selector: 'app-client-create',
  standalone: true,
  imports: [
    FormsModule
  ],
  templateUrl: './client-create.component.html',
  styleUrl: './client-create.component.scss'
})
export class ClientCreateComponent {

  client: ClientVo;
  @Output() formCancelled = new EventEmitter<void>();
  @Output() reloadList = new EventEmitter<void>();

  constructor(
    private clientService: ClientService,
  ) {
    this.client = new ClientVo();
    this.client.person = new PersonVo();
  }

  /**
   * Save client form
   */
  clickForm() {
    this.clientService.saveClient(this.client).subscribe((response: ResponseVo)=>{
      if(response.message){
        alert(response.message);
        this.formCancelled.emit();
        this.reloadList.emit();
      }else{
        alert('Error al crear el cliente');
      }
    });
    
  }

  /**
   * Cancel form and emit event
   */
  cancelForm() {
    this.formCancelled.emit();
  }
}
